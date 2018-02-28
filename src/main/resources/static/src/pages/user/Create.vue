<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户</el-breadcrumb-item>
      <el-breadcrumb-item>创建用户</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="create-box">
        <el-input placeholder="请输入用户名" suffix-icon="el-icon-edit" v-model="username">
        <template slot="prepend">姓名：</template>
        </el-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserCreate",
  data: () => {
    msg: "";
  }
};
</script>

<style>
.create-box {
    width: 360px;
}
</style>
