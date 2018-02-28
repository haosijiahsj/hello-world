<template>
  <div id="app">
    <div class="login-box">
      <my-head msg="用户登录"></my-head>
      <el-input placeholder="请输入用户名" suffix-icon="el-icon-edit" v-model="username">
        <template slot="prepend">用户名：</template>
      </el-input>
      <br/>
      <br/>
      <el-input type="password" placeholder="请输入密码" suffix-icon="el-icon-edit" v-model="password">
        <template slot="prepend">密&nbsp;&nbsp;&nbsp;码：</template>
      </el-input>
      <div class="registry-tip-box">
        <span>没有账号？<router-link to="/registry">立即注册</router-link></span>
      </div>
      <br/>
      <br/>
      <div class="login-btn-box">
        <el-button class="login-btn" type="primary" @click="login">登录</el-button>
      </div>
      <br/>
      <br/>
    </div>
  </div>
</template>

<script>
import MyHead from "@/components/MyHead";

export default {
  name: "MyHead",
  components: {
    "my-head": MyHead
  },
  data() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    login() {
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
      let self = this;
      console.log(process.env.API_HOST);
      var url = process.env.API_HOST + "/user/login";
      this.$axios.get(url, {
        params: {
          username: self.username,
          password: self.password
        }
      })
        .then(res => {
          var json = res.data;
          if (json.code == 200) {
            this.$message({
              message: "登录成功！",
              type: "success"
            });
            setTimeout(() => {
              this.$router.push({ path: "/main/dashboard" });
            }, 2000);
          } else {
            this.$message.error(json.msg);
          }
        })
        .catch(error => {
          this.$message.error(error);
        });
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

.login-btn {
  width: 100%;
}

.registry-tip-box {
  margin-top: 5px;
  text-align: right;
  font-size: 13px;
  color: #ddd;
}
.registry-tip-box a {
  color: #409eff;
  text-decoration: none;
}
</style>
