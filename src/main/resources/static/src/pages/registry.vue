<template>
  <div id="app">
    <div class="login-box">
      <my-head msg="用户注册"></my-head>
      <el-input placeholder="请输入用户名" suffix-icon="el-icon-edit" v-model="username">
        <template slot="prepend">用户名：</template>
      </el-input>
      <br/>
      <br/>
      <el-input type="password" placeholder="请输入密码" suffix-icon="el-icon-edit" v-model="password">
        <template slot="prepend">密&nbsp;&nbsp;&nbsp;码：</template>
      </el-input>
      <br/>
      <br/>
      <el-input type="password" placeholder="请输入密码" suffix-icon="el-icon-edit" v-model="confirm_password">
        <template slot="prepend">确&nbsp;&nbsp;&nbsp;认：</template>
      </el-input>
      <div class="login-tip-box">
        <span>已有账号？<router-link to="/login">立即登录</router-link></span>
      </div>
      <br/>
      <br/>
      <div class="login-btn-box">
        <el-button type="primary" @click="registry">立即注册</el-button>
        <el-button size="mini" @click="reset">重置</el-button>
      </div>
      <br/>
      <br/>
    </div>
  </div>
</template>

<script>
import MyHead from "@/components/MyHead";

export default {
  name: "Registry",
  components: {
    "my-head": MyHead
  },
  data() {
    return {
      username: '',
      password: '',
      confirm_password: ''
    };
  },
  methods: {
    registry() {
      if (this.username == "") {
        this.$message({
          message: "请输入用户名！",
          type: "warning"
        });
        return;
      }
      if (this.password == "") {
        this.$message({
          message: "请输入密码！",
          type: "warning"
        });
        return;
      }
      if (this.password.length < 6) {
        this.$message({
          message: "密码长度为6位以上！",
          type: "warning"
        });
        return;
      }
      if (this.confirm_password == "") {
        this.$message({
          message: "请再次输入密码！",
          type: "warning"
        });
        return;
      }
      if (this.confirm_password != this.password) {
        this.$message({
          message: "两次密码不一致！",
          type: "warning"
        });
        return;
      }
      var url = process.env.API_HOST+ "/user/registry";
      var that = this;
      this.$http({
        url: url,
        method: "post",
        data: {
            username: that.username,
            password: that.password
        }
      }).then(function(res) {
        var json = res.data;
        if (json.code == 200) {
          this.$message({
            message: "注册成功！",
            type: "success"
          });
          setTimeout(() => {
            this.$router.push({path: '/login'});
          }, 2000);
        } else {
          this.$message.error(json.msg);
        }
      });
    },
    reset() {
      this.username = "";
      this.password = "";
    }
  }
};
</script>

<style>
.login-box {
  width: 360px;
  margin: auto;
  margin-top: 50px;
}

.login-btn-box {
  width: 100%;
}

.login-tip-box {
  margin-top: 5px;
  text-align: right;
  font-size: 13px;
  color: #ddd;
}
.login-tip-box a {
  color: #409EFF;
  text-decoration: none;
}
</style>
