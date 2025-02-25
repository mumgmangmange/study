<script>
export default {
  data() {
    return {
      calculatorInfo: ''
    }
  },
  methods: {
    dataHandler($event) {
      const inputData = $event.target.value;
      // 연산자 중복 및 첫번째 입력값 연산자 추가시에 대한 대응 
      if (!(["*", "-", "/", "+", "."].includes(this.calculatorInfo.slice(-1)) && ["*", "-", "/", "+", "."].includes(inputData)) && !(this.calculatorInfo.length == 0 && ["*", "-", "/", "+", "."].includes(inputData))) {
        this.calculatorInfo += inputData;
      }
    },
    resultData() {
      console.log(`${this.calculatorInfo}`);
      const resultFunction = new Function(`return ${this.calculatorInfo}`);
      console.log(resultFunction());
      this.calculatorInfo = resultFunction();
    },
    clearHandler() {
      this.calculatorInfo = '';
    }
  }
}
</script>

<template>
  <!DOCTYPE html>
    <html lang="ko">
      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Calculator</title>
      </head>
      <body>
        <div class="calculator">
          <form name="forms">
            <input type="text" name="output" readonly v-model="calculatorInfo"/>
            <input type="button" class="clear" value="C" @click="clearHandler"/>
            <input type="button" class="operator" value="/" @click="dataHandler"/>
            <input type="button" value="1" @click="dataHandler"/>
            <input type="button" value="2" @click="dataHandler"/>
            <input type="button" value="3" @click="dataHandler"/>
            <input type="button" class="operator" value="*" @click="dataHandler"/>
            <input type="button" value="4" @click="dataHandler"/>
            <input type="button" value="5" @click="dataHandler" />
            <input type="button" value="6" @click="dataHandler"/>
            <input type="button" class="operator" value="+" @click="dataHandler"/>
            <input type="button" value="7" @click="dataHandler"/>
            <input type="button" value="8" @click="dataHandler"/>
            <input type="button" value="9" @click="dataHandler"/>
            <input type="button" class="operator" value="-" @click="dataHandler"/>
            <input type="button" class="dot" value="." @click="dataHandler"/>
            <input type="button" value="0" @click="dataHandler"/>
            <input type="button" class="operator result" value="=" @click="resultData"/>
          </form>
        </div>
      </body>
    </html>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  background-color: #ffffff;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.calculator {
  width: 287px;
  border: 1px solid #333;
  background-color: #ccc;
  padding: 5px;
}

.calculator form {
  display: grid;
  grid-template-columns: repeat(4, 65px);
  grid-auto-rows: 65px;
  grid-gap: 5px;
}

.calculator form input {
  border: 2px solid #333;
  cursor: pointer;
  font-size: 19px;
}

.calculator form input:hover {
  box-shadow: 1px 1px 2px #333;
}

.calculator form .clear {
  background-color: #ed4848;
}

.calculator form .operator {
  background-color: orange;
}

.calculator form .dot {
  background-color: green;
}

.calculator form input[type='text'] {
  grid-column: span 4;
  text-align: right;
  padding: 0 10px;
}

.calculator form .clear {
  grid-column: span 3;
}

.calculator form .result {
  grid-column: span 2;
}
</style>
