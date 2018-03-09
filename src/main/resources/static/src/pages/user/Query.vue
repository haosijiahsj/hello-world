<template>
    <div style="z-index: 9999;">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/main/dashboard' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>用户</el-breadcrumb-item>
          <el-breadcrumb-item>查询用户</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="query-box">
          <el-input class="query-inp" size="small" v-model="queryValue" placeholder="请输入用户名"></el-input>
          <el-button type="primary" icon="el-icon-search" size="small" @click="query"></el-button>
        </div>
        <el-table :data="tableData" border stripe highlight-current-row>
            <el-table-column header-align="center" align="center" prop="username" label="账号">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="name" label="姓名">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="sex" label="性别">
                <template slot-scope="scope">
                    <el-tag size="medium" :type="scope.row.sex == 1 ? 'success' : 'danger'">
                        {{ scope.row.sex == 1 ? '男' : '女' }}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="tel" label="电话">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="createTime" label="创建时间">
            </el-table-column>
            <el-table-column header-align="center" align="center" prop="status" label="状态">
                <template slot-scope="scope">
                    <el-tag size="medium" :type="scope.row.status == 1 ? 'success' : 'danger'">
                        {{ scope.row.status == 1 ? '可用' : '禁用' }}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column header-align="center" align="center" label="操作" width="180">
            <template slot-scope="scope">
                <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row, tableData)">删除</el-button>
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
      queryValue: "",
      tableData: [],
      currentPage: 1,
      pageSizes: [10, 20],
      pageSize: 10,
      total: 0
    };
  },
  methods: {
    loadData(username, page, size) {
      var url = "/user/findUserByPage";
      this.tableData = [];
      this.$axios
        .get(url, {
          params: {
            username: username,
            page: page,
            size: size
          }
        })
        .then(res => {
          var json = res.data.content;
          if (res.data.code == 200) {
            this.tableData = json.content;
            this.total = json.totalElements;
          } else {
            this.$message.error(res.data.msg);
          }
        })
        .catch(err => {
          this.$message.error(err);
        });
    },
    query() {
      this.loadData(this.queryValue, this.currentPage, this.pageSize);
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.loadData(this.queryValue, this.currentPage, this.pageSize);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.loadData(this.queryValue, this.currentPage, this.pageSize);
    },
    handleEdit(index, row) {
      this.$router.push({ name: "UserEdit", params: { id: row.id } });
    },
    handleDelete(index, row, tableData) {
      this.$confirm("确定要删除该条数据？", "确定删除", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        var url = "/user/delete";;
        this.$axios({
            url: url,
            method: "delete",
            params: {
              id: row.id
            }
          })
          .then(res => {
            if (res.data.code == 200) {
              tableData.splice(index, 1);
              this.$message({
                message: "删除成功！",
                type: "success"
              });
            } else {
              this.$message.error(res.data.msg);
            }
          })
          .catch();
      });
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
