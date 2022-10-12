<!-- ----------------------- -->
<!-- TODO侧边栏----------------- -->
<!-- ----------------------- -->
<template>
    <el-menu default-active="/testManagement" class="el-menu-vertical-demo" router>

    <el-submenu index="1">
      <template slot="title"><i class="el-icon-message"></i>系统管理</template>
      <el-menu-item-group>
        <template slot="title">分组一</template>
        <el-menu-item index="/index/UserListUserDetail">用户Eacharts总览</el-menu-item>
        <el-menu-item index="/index/UserDetail">用户List</el-menu-item>
      </el-menu-item-group>
      <el-menu-item-group title="分组2">
        <el-menu-item index="/index/UserInterest">用户兴趣管理</el-menu-item>
      </el-menu-item-group>
    </el-submenu>


    <el-submenu index="2">
      <template slot="title"><i class="el-icon-message"></i>商品管理</template>
      <el-menu-item-group>
        <template slot="title">分组一</template>
        <el-menu-item index="/index/">商品基本情况Eacharts</el-menu-item>
        <el-menu-item index="/index/GoodsList">商品List</el-menu-item>
        <el-menu-item index="/index/GoodsDetail" disabled>商品detail</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <el-menu-item index="/index/help"><i class="el-icon-menu"></i>商品管理</el-menu-item>
    <el-menu-item index="/index/feedback"><i class="el-icon-setting"></i>意见反馈</el-menu-item>

  </el-menu>
  </el-col>
</template>
