<script>
export default {
  data() {
    return {
      todo_text: '',
      todo_list: [],
      activeTab: 'all'
    }
  },
  methods: {
    register() {
      if (this.todo_text.trim() === '') return; // 빈 입력 방지

      // 새로운 할 일 객체 생성 후 배열에 추가
      this.todo_list.push({
        id: Date.now(),
        text: this.todo_text,
        completed: false
      });

      this.todo_text = ''; // 입력 필드 초기화
    },
    deleteItem(index) {
      this.todo_list.splice(index, 1);
    },
    setActiveTab(tab) {
      this.activeTab = tab;
    }
  },
  computed: {
    filteredTodos() {
      if (this.activeTab === 'completed') {
        return this.todo_list.filter(item => item.completed);
      }
      return this.todo_list;
    }
  }
}
</script>

<template>
  <body>
    <div class="todo">
      <div class="todo__title">
        <h1 class="todo__text">Todo List</h1>
        <ul class="todo__tab">
          <li 
            :class="{ 'todo__tab--active': activeTab === 'all' }"
            @click="setActiveTab('all')">
            전체
          </li>
          <li 
            :class="{ 'todo__tab--active': activeTab === 'completed' }"
            @click="setActiveTab('completed')">
            완료
          </li>
        </ul>
      </div>
      <div class="todo__list">
        <!-- 할 일 목록이 있을 때 (완료 시 .todo__item--completed 클래스 추가 )-->
          <div class="todo_area">
            <div v-for="(item, index) in filteredTodos" 
            :key="item.id" 
            class="todo__item">
              <input type="checkbox"
               :id="'chk' + item.id" 
               v-model="item.completed"
                />
                <label :for="'chk' + item.id" class="todo__checkbox-label"></label>

                <!-- 할 일 텍스트 (완료 시 줄 긋기) -->
                <span class="todo__item-text" :class="{ 'todo__item--completed': item.completed }">
                    {{ item.text }}
                  </span>            

                <span class="material-symbols-outlined todo__delete-icon" @click="deleteItem(index)">
                  delete
                </span>
            </div>
          </div>
        <!-- 할 일 목록이 없을 때 -->
        <div class="todo__item--no" style="display: none">
          <p>할일 목록이 없습니다.</p>
        </div>
      </div>
      <div class="todo__input">
        <input
          type="text"
          class="todo__input-text"
          placeholder="할 일을 입력하세요."
          v-model="todo_text"
        />
        <button class="todo__input-btn" @click="register">등록</button>
      </div>
    </div>
  </body>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f3f0ff;
  background-color: white;
}

.todo {
  width: 350px;
  background-color: #f4fafd;
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 16px 0;
}

.todo__title {
  text-align: center;
  border-bottom: 1px solid #f9f9f9;
}

.todo__tab {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-top: 16px;
  font-size: 14px;
  cursor: pointer;
  color: #333;
}

.todo__tab--active {
  color: blue;
  font-weight: bold;
}

.todo__text {
  font-family: 'Gabarito', sans-serif;
  font-size: 20px;
}

.todo__list {
  padding: 0 1rem;
  height: 412px;
  overflow: auto;
}

.todo__item {
  height: 50px;
  padding: 5px;
  border-radius: 10px;
  border: 1px solid #ccc;
  background-color: white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 16px 0;
}

.todo__item-text {
  flex-grow: 1;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  margin: 0 10px;
}

.todo__item--no {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  text-align: center;
  font-size: 14px;
  color: #333;
}

.todo__item input[type='checkbox'] {
  display: none;
}

.todo__item input[type='checkbox'] + label {
  display: inline-block;
  width: 20px;
  height: 20px;
  border: 3px solid #707070;
  position: relative;
  flex-shrink: 0;
}
.todo__item input[type='checkbox']:checked + label::after {
  content: '✔';
  font-size: 11px;
  width: 15px;
  height: 20px;
  text-align: center;
  position: absolute;
  left: 0;
  top: 0;
}

.todo__delete-icon {
  flex-shrink: 0;
}

.todo__item--completed {
  background-color: #e2dede;
}

.todo__item--completed .todo__item-text {
  text-decoration: line-through;
}

.todo__input {
  padding: 0 1rem;
  display: flex;
  height: 40px;
}

.todo__input-text {
  flex-grow: 1;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 5px;
  padding: 0 10px;
}

.todo__input-btn {
  flex-shrink: 0;
  border: none;
  border-radius: 5px;
  background-color: blue;
  font-size: 13px;
  color: white;
  padding: 5px;
  border: none;
  cursor: pointer;
}
</style>
