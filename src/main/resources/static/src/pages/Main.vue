<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-header class="top-nav-header">
      <el-menu class="top-nav-menu" mode="horizontal">
        <el-menu-item index="1">处理中心</el-menu-item>
        <el-menu-item index="2">我的工作台</el-menu-item>
        <el-menu-item index="3">消息中心</el-menu-item>
        <el-menu-item index="4">订单管理</el-menu-item>
        <el-submenu index="5" style="float: right;">
          <template slot="title">胡胜钧</template>
          <el-menu-item index="5-1"><Icon type="edit"></Icon>&nbsp;&nbsp;修改密码</el-menu-item>
          <el-menu-item index="5-2"><Icon type="log-out"></Icon>&nbsp;&nbsp;退出登录</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu router :default-active="$route.path" class="left-nav-menu">
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
      <el-container style="height: 680px;">
        <el-main>
          <!-- 加上keep-alive导航点击才不会报错... -->
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </el-main>
        <el-footer>
          <a href="https://github.com/haosijiahsj/hello-world" target="_blank">
            <Icon type="social-github"></Icon>&nbsp;&nbsp;&nbsp;<span>spring-boot & vue</span>
          </a>
        </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<style>
.top-nav-menu {
  border-bottom: 1px solid #eee;
  z-index: 999;
}

.left-nav-menu {
  height: 100%;
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
  name: "Main"
};
</script>