<template>
  <div id="app">
    <div class="login-box">
      <login-head></login-head>
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
      <div class="login-btn-box">
        <el-button type="primary" @click="login">登录</el-button>
        <el-button size="mini" @click="reset">重置</el-button>
      </div>
      <br/>
      <br/>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import VueResource from "vue-resource";
import LoginHead from "@/components/LoginHead";

Vue.use(ElementUI);
Vue.use(VueResource);

export default {
  name: "Login",
  components: {
    "login-head": LoginHead
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
      var url =
        "/api/user/login?username=" +
        this.username +
        "&password=" +
        this.password;
      this.$http({
        url: url,
        method: "get"
      }).then(function(res) {
        var json = res.data;
        if (json.code == 200) {
          this.$message({
            message: "登录成功！",
            type: "success"
          });
          setTimeout(() => {
            this.$router.push({ path: "/" });
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
</style>
