<template>
    <!-- <button class="btn">클릭</button> -->
    <button class="btn">  <slot></slot></button>
</template>
<style>
.btn {
    width: 80px;
    height: 40px;
    background-color: blue;
    color: white;
    border: none;
    border-radius: 5px;
}
</style>