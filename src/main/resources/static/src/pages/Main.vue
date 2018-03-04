<template>
  <el-container style="border: 1px solid #eee; height: 100%;">
      <el-aside width="200px">
        <el-menu router :default-active="$route.path" :collapse="isCollapse" class="left-nav-menu">
          <div class="left-nav-header-box">
            <span><Icon type="ionic"></Icon>&nbsp;&nbsp;&nbsp;Hello World</span>
          </div>
          <el-menu-item index="/main/dashboard">
            <Icon type="home" size="18"></Icon>
            <span slot="title">&nbsp;&nbsp;首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <Icon type="person" size="18"></Icon>
              <span>&nbsp;&nbsp;用户</span>
            </template>            
            <el-menu-item index="/main/user/create"><Icon type="plus-round"></Icon>&nbsp;&nbsp;创建</el-menu-item>
            <el-menu-item index="/main/user/query"><Icon type="search"></Icon>&nbsp;&nbsp;查询</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header class="top-nav-header">
          <el-menu class="top-nav-menu" mode="horizontal">
            <el-menu-item index="1">我的工作台</el-menu-item>
            <el-submenu index="5" style="float: right;">              
              <template slot="title">胡胜钧</template>
              <el-menu-item index="5-1" @click.native="changePass"><Icon type="edit"></Icon>&nbsp;&nbsp;修改密码</el-menu-item>
              <el-menu-item index="5-2" @click.native="logout"><Icon type="log-out"></Icon>&nbsp;&nbsp;退出登录</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-header>
        <el-main style="border-top: 1px solid #eee;">
          <router-view></router-view>        
        </el-main>
        <el-footer>
          <a href="https://github.com/haosijiahsj/hello-world" target="_blank">
            <Icon type="social-github"></Icon>&nbsp;&nbsp;&nbsp;<span>spring-boot & vue</span>
          </a>
        </el-footer>
      </el-container>
      <Spin size="large" fix v-if="spinShow"></Spin>
  </el-container>
</template>

<style scoped>
.top-nav-menu {
  border: 0;
}

.left-nav-menu {
  height: 100%;
}

.left-nav-header-box {
  text-align: center;
  font-size: 20px;
  font-weight: 700;
  height: 61px;
  line-height: 61px;
  border-bottom: 1px solid #eee
}

.el-footer {
  border-top: 1px solid #eee;
  line-height: 60px;
  text-align: center;
  font-size: 16px;
}
.el-footer a {
  text-decoration: none;
  color: #50bfff;
}
</style>

<script>
export default {
  name: "Main",
  data() {
    return {
      spinShow: true,
      isCollapse: false
    }
  },
  mounted() {
    setTimeout(() => {
      this.spinShow = false;
    }, 2000);
  },
  methods: {
    changePass() {
      console.log("修改密码");
    },
    logout() {
      this.$confirm('确定要退出登录吗？', '退出登录', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$router.push({ path: "/login" });
        });
    }
  }
};
</script>