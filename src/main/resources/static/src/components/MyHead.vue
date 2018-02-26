<template>
  <div class='tip'><p>{{msg}}</p></div>
</template>

<script>
export default {
  name: "MyHead",
  props: {
    msg: {
      default: 'Hello World'
    }
  }
};
</script>

<style>
.tip {
    padding: 6px 10px;
    background-color: #ecf8ff;
    border-radius: 4px;
    border-left: 5px solid #50bfff;
    margin: 24px 0;
    text-align: left;
}

.tip p {
    font-size: 14px;
}
</style>
