webpackJsonp([1],{0:function(e,t){},JK0I:function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=n("VCXJ"),a={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var i=n("Z0/y")({name:"App"},a,!1,function(e){n("VcOi")},null,null).exports,l=n("zO6J"),r=n("epGn"),o=n.n(r),u=(n("qbEQ"),n("lLMz")),m={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"tip"},[t("p",[this._v(this._s(this.msg))])])},staticRenderFns:[]};var d=n("Z0/y")({name:"LoginHead",data:function(){return{msg:"用户登录"}}},m,!1,function(e){n("JK0I")},null,null).exports;s.default.use(o.a),s.default.use(u.a);var p={name:"Login",components:{"login-head":d},data:function(){return{username:"",password:""}},methods:{login:function(){if(""!=this.username)if(""!=this.password)if(this.password.length<6)this.$message({message:"密码长度为6位以上！",type:"warning"});else{var e="/user/login?username="+this.username+"&password="+this.password;this.$http({url:e,method:"get"}).then(function(e){var t=this,n=e.data;200==n.code?(this.$message({message:"登录成功！",type:"success"}),setTimeout(function(){t.$router.go({name:"/"})},2e3)):this.$message.error(n.msg)})}else this.$message({message:"请输入密码！",type:"warning"});else this.$message({message:"请输入用户名！",type:"warning"})},reset:function(){this.username="",this.password=""}}},v={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("div",{staticClass:"login-box"},[n("login-head"),e._v(" "),n("el-input",{attrs:{placeholder:"请输入用户名","suffix-icon":"el-icon-edit"},model:{value:e.username,callback:function(t){e.username=t},expression:"username"}},[n("template",{slot:"prepend"},[e._v("用户名：")])],2),e._v(" "),n("br"),e._v(" "),n("br"),e._v(" "),n("el-input",{attrs:{type:"password",placeholder:"请输入密码","suffix-icon":"el-icon-edit"},model:{value:e.password,callback:function(t){e.password=t},expression:"password"}},[n("template",{slot:"prepend"},[e._v("密   码：")])],2),e._v(" "),n("br"),e._v(" "),n("br"),e._v(" "),n("div",{staticClass:"login-btn-box"},[n("el-button",{attrs:{type:"primary"},on:{click:e.login}},[e._v("登录")]),e._v(" "),n("el-button",{attrs:{size:"mini"},on:{click:e.reset}},[e._v("重置")])],1),e._v(" "),n("br"),e._v(" "),n("br")],1)])},staticRenderFns:[]};var c=n("Z0/y")(p,v,!1,function(e){n("zrvW")},null,null).exports,_={name:"Main",data:function(){return{tableData:Array(20).fill({date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"})}}},g={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-container",{staticStyle:{height:"100%",border:"1px solid #eee"}},[n("el-aside",{staticStyle:{"background-color":"rgb(238, 241, 246)"},attrs:{width:"200px"}},[n("el-menu",{attrs:{"default-openeds":["1","3"]}},[n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-message"}),e._v("导航一")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"1-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"1-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-4-1"}},[e._v("选项4-1")])],2)],2),e._v(" "),n("el-submenu",{attrs:{index:"2"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-menu"}),e._v("导航二")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"2-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"2-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-4-1"}},[e._v("选项4-1")])],2)],2),e._v(" "),n("el-submenu",{attrs:{index:"3"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-setting"}),e._v("导航三")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"3-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"3-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-4-1"}},[e._v("选项4-1")])],2)],2)],1)],1),e._v(" "),n("el-container",{staticStyle:{height:"680px"}},[n("el-header",{staticStyle:{"text-align":"right","font-size":"12px"}},[n("el-dropdown",[n("i",{staticClass:"el-icon-setting",staticStyle:{"margin-right":"15px"}}),e._v(" "),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[e._v("查看")]),e._v(" "),n("el-dropdown-item",[e._v("新增")]),e._v(" "),n("el-dropdown-item",[e._v("删除")])],1)],1),e._v(" "),n("span",[e._v("王小虎")])],1),e._v(" "),n("el-main",[n("el-table",{attrs:{data:e.tableData}},[n("el-table-column",{attrs:{prop:"date",label:"日期",width:"140"}}),e._v(" "),n("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120"}}),e._v(" "),n("el-table-column",{attrs:{prop:"address",label:"地址"}})],1)],1)],1)],1)},staticRenderFns:[]};var f=n("Z0/y")(_,g,!1,function(e){n("tkmy")},null,null).exports;s.default.use(l.a);var h=new l.a({routes:[{path:"/",name:"Main",component:f},{path:"/login",name:"Login",component:c}]});s.default.config.productionTip=!1,new s.default({el:"#app",router:h,components:{App:i},template:"<App/>"})},VcOi:function(e,t){},qbEQ:function(e,t){},tkmy:function(e,t){},zrvW:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.45cfb8094451be8b60ea.js.map