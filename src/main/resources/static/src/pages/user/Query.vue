<template>
    <div>
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>用户</el-breadcrumb-item>
          <el-breadcrumb-item>查询用户</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="query-box">
          <el-input class="query-inp" size="small" v-model="queryValue" placeholder="请输入用户名"></el-input>
          <el-button type="primary" icon="el-icon-search" size="small" @click="query"></el-button>
        </div>
        <el-table :data="tableData" border stripe highlight-current-row>
            <el-table-column header-align="center" align="center" prop="username" label="账号" width="180">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="name" label="姓名" width="180">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="tel" label="电话">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="createTime" label="创建时间">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="status" label="状态" width="100">
                <template slot-scope="scope">
                    <el-tag size="medium" :type="scope.row.status == 1 ? 'success' : 'danger'">
                        {{ scope.row.status == 1 ? '可用' : '禁用' }}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column header-align="center" align="center" label="操作" width="180">
            <template slot-scope="scope">
                <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
            </el-table-column>
        </el-table>
        <div class="pag-box">
        <el-pagination            
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="pageSizes"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
        </el-pagination>
        </div>
    </div>
</template>

<script>
export default {
  name: "UserQuery",
  data() {
    return {
      queryValue: '',
      tableData: [],
      currentPage: 1,
      pageSizes: [10, 20, 30],
      pageSize: 10,
      total: 50
    };
  },
  methods: {
      query() {          
          var self = this;
          let queryValue = this.queryValue;
          var url = process.env.API_HOST + "/user";
          if (queryValue == "") {
              url += "/findAll";
          } else {
              url = url + "/findByUsername?username=" + queryValue;
          }
          this.tableData = [];
          this.$axios.get(url)
        .then(res => {
            var content = res.data.content;
        
            if (content instanceof Array) {
                self.tableData = content;
            } else {
                self.tableData = new Array(content);
            }            
        })
        .catch(res => {});
      }
  }
};
</script>

<style scoped>
  .query-box {
      width: 100%;
      margin-top: 15px;
      margin-bottom: 12px;
  }

  .query-inp {
      width: 200px;
  }

  .el-pagination {
      text-align: right;
      margin-top: 5px;
      margin-bottom: 20px;
  }
</style>
