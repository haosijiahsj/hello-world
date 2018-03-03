<template>
  <div class="create-user-box">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/main/dashboard' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户</el-breadcrumb-item>
      <el-breadcrumb-item>创建用户</el-breadcrumb-item>
    </el-breadcrumb>
    <el-form :model="form" ref="form" status-icon :rules="rules" label-width="80px">
      <el-form-item label="用户名：" prop="username">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="密码：" prop="password">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="姓名：" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="性别：">
        <el-radio-group v-model="form.sex">
          <el-radio label="1">男</el-radio>
          <el-radio label="0">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="电话：" prop="tel">
        <el-input v-model="form.tel"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit('form')">立即创建</el-button>
        <el-button @click="reset('form')" plain size="medium">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  export default {
    data() {
      var checkUsername = (rule, value, callback) => {
        var url = "/user/findByUsername?username=" + value;
          this.$axios.get(url)
          .then((res) => {
            if (res.data.content != null) {
              callback(new Error('用户名已存在，请重新输入！'));
            } else {
              callback();
            }
          })
          .catch((error) => {
            callback(new Error(error));
          });
      };
      return {
        form: {
          username: '',
          password: '',
          name: '',
          sex: '1',
          tel: ''
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { validator: checkUsername, trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, message: '长度在6位以上', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' }
          ],
          tel: [
            { min: 11, message: '长度11位以上', trigger: 'blur' },
            { pattern: /^1[34578]\d{9}$/, message: '请输入正确的手机号', trigger: 'blur' }
          ]
        },
      }      
    },    
    methods: {
      submit(formName) {
        self = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url = "/user/create";
            this.$axios.post(url, JSON.stringify(self.form), {headers: {"Content-Type": "application/json"}})
            .then((res) => {
              if (res.data.code == 200) {
                this.$message({
                  message: '创建成功！',
                  type: 'success'
                });
                setTimeout(() => {
                  self.$refs[formName].resetFields();
                }, 2000);                
              } else {
                this.$message.error(res.data.msg);
              }
            })
            .catch((error) => {
              this.$message.error(error);
            });
          } else {
            this.$message.error('请完成表单必填项！');
            return false;
          }
        });
      },
      reset(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
.create-user-box {
  width: 400px;
}
</style>
