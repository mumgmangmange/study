// import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

//import FirstChild from '@/components/FirstChild.vue';

const app = createApp(App);
// app.component('FirstChild', FirstChild); // 컴포넌트 추가 
app.provide('globalMessage', 'hello');
app.mount('#app');
