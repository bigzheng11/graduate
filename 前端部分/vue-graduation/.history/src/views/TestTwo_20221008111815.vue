<template>
   <div class="container">
      <div class="block">
         <span class="demonstration">默认 click 触发子菜单</span>
         <el-cascader
            v-model="value"
            :options="options"
            @change="handleChange"
         ></el-cascader>
      </div>
      <div class="block">
         <span class="demonstration">hover 触发子菜单</span>
         <el-cascader
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange"
         ></el-cascader>
      </div>
   </div>
</template>

<script>
import axios from "axios";
export default {
   data() {
      return {
         value: [],
         options: [
            {
               value: "zhinan",
               label: "指南",
               children: [
                  {
                     value: "shejiyuanze",
                     label: "设计原则",
                     children: [
                        {
                           value: "yizhi",
                           label: "一致",
                        },
                        {
                           value: "fankui",
                           label: "反馈",
                        },
                        {
                           value: "xiaolv",
                           label: "效率",
                        },
                        {
                           value: "kekong",
                           label: "可控",
                        },
                     ],
                  },
                  {
                     value: "daohang",
                     label: "导航",
                     children: [
                        {
                           value: "cexiangdaohang",
                           label: "侧向导航",
                        },
                        {
                           value: "dingbudaohang",
                           label: "顶部导航",
                        },
                     ],
                  },
               ],
            },
            {
               value: "zujian",
               label: "组件",
               children: [
                  {
                     value: "basic",
                     label: "Basic",
                     children: [
                        {
                           value: "layout",
                           label: "Layout 布局",
                        },
                        {
                           value: "color",
                           label: "Color 色彩",
                        },
                        {
                           value: "typography",
                           label: "Typography 字体",
                        },
                        {
                           value: "icon",
                           label: "Icon 图标",
                        },
                        {
                           value: "button",
                           label: "Button 按钮",
                        },
                     ],
                  },
                  {
                     value: "form",
                     label: "Form",
                     children: [
                        {
                           value: "radio",
                           label: "Radio 单选框",
                        },
                        {
                           value: "checkbox",
                           label: "Checkbox 多选框",
                        },
                        {
                           value: "input",
                           label: "Input 输入框",
                        },
                        {
                           value: "input-number",
                           label: "InputNumber 计数器",
                        },
                        {
                           value: "select",
                           label: "Select 选择器",
                        },
                        {
                           value: "cascader",
                           label: "Cascader 级联选择器",
                        },
                        {
                           value: "switch",
                           label: "Switch 开关",
                        },
                        {
                           value: "slider",
                           label: "Slider 滑块",
                        },
                        {
                           value: "time-picker",
                           label: "TimePicker 时间选择器",
                        },
                        {
                           value: "date-picker",
                           label: "DatePicker 日期选择器",
                        },
                        {
                           value: "datetime-picker",
                           label: "DateTimePicker 日期时间选择器",
                        },
                        {
                           value: "upload",
                           label: "Upload 上传",
                        },
                        {
                           value: "rate",
                           label: "Rate 评分",
                        },
                        {
                           value: "form",
                           label: "Form 表单",
                        },
                     ],
                  },
                  {
                     value: "data",
                     label: "Data",
                     children: [
                        {
                           value: "table",
                           label: "Table 表格",
                        },
                        {
                           value: "tag",
                           label: "Tag 标签",
                        },
                        {
                           value: "progress",
                           label: "Progress 进度条",
                        },
                        {
                           value: "tree",
                           label: "Tree 树形控件",
                        },
                        {
                           value: "pagination",
                           label: "Pagination 分页",
                        },
                        {
                           value: "badge",
                           label: "Badge 标记",
                        },
                     ],
                  },
                  {
                     value: "notice",
                     label: "Notice",
                     children: [
                        {
                           value: "alert",
                           label: "Alert 警告",
                        },
                        {
                           value: "loading",
                           label: "Loading 加载",
                        },
                        {
                           value: "message",
                           label: "Message 消息提示",
                        },
                        {
                           value: "message-box",
                           label: "MessageBox 弹框",
                        },
                        {
                           value: "notification",
                           label: "Notification 通知",
                        },
                     ],
                  },
                  {
                     value: "navigation",
                     label: "Navigation",
                     children: [
                        {
                           value: "menu",
                           label: "NavMenu 导航菜单",
                        },
                        {
                           value: "tabs",
                           label: "Tabs 标签页",
                        },
                        {
                           value: "breadcrumb",
                           label: "Breadcrumb 面包屑",
                        },
                        {
                           value: "dropdown",
                           label: "Dropdown 下拉菜单",
                        },
                        {
                           value: "steps",
                           label: "Steps 步骤条",
                        },
                     ],
                  },
                  {
                     value: "others",
                     label: "Others",
                     children: [
                        {
                           value: "dialog",
                           label: "Dialog 对话框",
                        },
                        {
                           value: "tooltip",
                           label: "Tooltip 文字提示",
                        },
                        {
                           value: "popover",
                           label: "Popover 弹出框",
                        },
                        {
                           value: "card",
                           label: "Card 卡片",
                        },
                        {
                           value: "carousel",
                           label: "Carousel 走马灯",
                        },
                        {
                           value: "collapse",
                           label: "Collapse 折叠面板",
                        },
                     ],
                  },
               ],
            },
            {
               value: "ziyuan",
               label: "资源",
               children: [
                  {
                     value: "axure",
                     label: "Axure Components",
                  },
                  {
                     value: "sketch",
                     label: "Sketch Templates",
                  },
                  {
                     value: "jiaohu",
                     label: "组件交互文档",
                  },
               ],
            },
         ],
      };
   },
   methods: {
      handleChange(value) {
         console.log(value);
      },
   },
};
</script>

<style scoped></style>

<!-- 
axios:

     axios
   .get("https://autumnfish.cn/api/joke/list?num=3") //获得三个笑话
   .then(function (response) {
   console.log(response);
 });

axios.get('url')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  })
  .then(function () {
  });
 -->

<!-- 

  信息列表
goodsClassify:[
{id:1,name:"芒果"},
{id:2,name:"鱼肉"},
{id:3,name:"波罗蜜"},
{id:4,name:"柚子"},
{id:5,name:"橙子"},
{id:6,name:"猕猴桃"},
{id:7,name:"苹果"},
{id:8,name:"草莓"},
{id:9,name:"卷心菜"},
{id:10,name:"西红柿"},
{id:11,name:"黄瓜"},
{id:12,name:"大白菜"},
{id:13,name:"西兰花"},
{id:14,name:"萝卜"},
{id:15,name:"生菜"},
{id:16,name:"金针菇"},
{id:17,name:"大葱"},
{id:18,name:"韭菜"},
{id:19,name:"南瓜"},
{id:20,name:"空心菜"},

]


  -->
