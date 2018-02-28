<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-header class="top-nav-header">
      <el-menu class="top-nav-menu" :default-active="activeIndex" mode="horizontal" @select="handleSelect">
        <el-menu-item index="1">处理中心</el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项1</el-menu-item>
            <el-menu-item index="2-4-2">选项2</el-menu-item>
            <el-menu-item index="2-4-3">选项3</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3">消息中心</el-menu-item>
        <el-menu-item index="4">订单管理</el-menu-item>
        <el-submenu index="5" style="float: right;">
          <template slot="title">胡胜钧</template>
          <el-menu-item index="5-1"><i class="el-icon-edit-outline"></i>修改密码</el-menu-item>
          <el-menu-item index="5-2"><i class="el-icon-back"></i>退出登录</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu router :default-active="$route.path" class="left-nav-menu" @open="handleOpen" @close="handleClose">
          <el-menu-item index="/main/dashboard">
            <Icon type="home" size="18"></Icon>
            <span slot="title">&nbsp;&nbsp;首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <Icon type="person" size="18"></Icon>
              <span>&nbsp;&nbsp;用户</span>
            </template>            
            <el-menu-item index="/main/user/create">创建</el-menu-item>
            <el-menu-item index="/main/user/query">查询</el-menu-item>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3">
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
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
            <span>spring-boot & vue</span>&nbsp;&nbsp;&nbsp;<Icon type="social-github"></Icon>
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
  name: "Main",
  data: () => {
    msg: ''
  }
};
</script>