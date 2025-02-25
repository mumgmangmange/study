<script>
import FirstChild from './components/FirstChild.vue';
import CustomButton from './components/CustomButton.vue';

  export default {
    data: function() {
      return {
        name: '<h3>망망</h3>',
        age: 10,
        gender: '여자',
        uid: '',
        pwd: ''
      };
    }, 
    methods: { // 메소드 정의
      clickHandler(message) {
        alert('hello!' + message);
      },
      login() {
        console.log(`${this.uid}`); // 템플릿 리터럴 `${}`
        console.log(`${this.pwd}`);
      },
    }, 
    components: {
      FirstChild,
      CustomButton
    },
  }
</script>
<template>
  <div v-html="name"></div> 이고 {{ age }} 살 입니다.
  <button type="button" v-on:click="clickHandler('a')">클릭</button>
  <button type="button" v-on:dblclick="clickHandler('b')">더블클릭</button>
  <button type="button" @dblclick="clickHandler('c')">더블클릭2</button>
  <div v-memo="[name, gender]">
    <p>이름: {{ name }}</p>
    <p>성별: {{ gender }}</p>
  </div>
  <form>
    <div>아이디: <input type="text" id="uid" v-model="uid"></div>
    <div>패스워드: <input type="password" id="pwd" v-model="pwd"></div>
    <button type="button" @click="login">로그인</button>
  </form>

  <br>
  <FirstChild/>
  <!-- <CustomButton/> -->
  <CustomButton>더블클릭</CustomButton>
</template>
<style></style>
