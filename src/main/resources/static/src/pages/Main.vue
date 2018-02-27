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
    </el-menu>
  </el-header>
  <el-container>
    <el-aside width="200px">
      <el-menu default-active="1" class="left-nav-menu" @open="handleOpen" @close="handleClose">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>导航一</span>
          </template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
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
        <!-- 这里是写切换路由后显示的内容 -->
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>1</el-breadcrumb-item>
          <el-breadcrumb-item>2</el-breadcrumb-item>
          <el-breadcrumb-item>3</el-breadcrumb-item>
        </el-breadcrumb>
        <el-table :data="tableData" border stripe highlight-current-row>
          <el-table-column header-align="center" align="center" prop="name" label="姓名" width="180">
            <template slot-scope="scope">
              <el-popover trigger="hover" placement="top">
                <p>姓名: {{ scope.row.name }}</p>
                <p>地址: {{ scope.row.address }}</p>
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium">{{ scope.row.name }}</el-tag>
                </div>
              </el-popover>
            </template>
          </el-table-column>
          <el-table-column header-align="center" align="center" prop="date" label="出生日期" width="140">
          </el-table-column>
          <el-table-column header-align="center" align="center" prop="address" label="地址">
          </el-table-column>
          <el-table-column header-align="center" align="center" label="操作" width="180">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
      <el-footer>
        <a href="https://github.com/haosijiahsj/hello-world" target="_blank">
          <span>spring-boot & vue</span>
        </a>
      </el-footer>
    </el-container>
  </el-container>
</el-container>
</template>

<style>
.el-breadcrumb {
  margin-bottom: 20px;
}

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
  font-size: 14px;
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
    const item = {
      date: "1995-10-01",
      name: "胡胜钧",
      address: "成都市"
    };
    return {
      tableData: Array(1).fill(item)
    };
  }
};
</script>