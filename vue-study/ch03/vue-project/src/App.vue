<script>
  export default {
    data: function() {
      return {
        name: '<h3>망망</h3>',
        age: 10
      };
    }
  }
</script>
<template>
  <div v-html="name"></div> 이고 {{ age }} 살 입니다.
</template>
<style></style>
