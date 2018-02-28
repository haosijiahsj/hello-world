<template>
    <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>用户</el-breadcrumb-item>
          <el-breadcrumb-item>查询用户</el-breadcrumb-item>
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
    </div>
</template>

<script>
export default {
  name: "UserQuery",
  data() {
    const item = {
      date: "1995-10-01",
      name: "胡胜钧",
      address: "四川省成都市"
    };
    return {
      tableData: Array(10).fill(item)
    };
  }
};
</script>

<style scoped>

</style>
