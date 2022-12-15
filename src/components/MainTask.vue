<script>
import { useQuery } from '@vue/apollo-composable'
import { useMutation } from '@vue/apollo-composable'
import { CREATE_TASK_MUTATION } from '../graphql/mutation/createTask'
import { TASK_COMPLETED_MUTATION } from '../graphql/mutation/taskCompleted'
import { GET_ALL_TASKS_QUERY } from '../graphql/queries/getList'

export default {

  //   props: {
  //     msg: String
  //   }
  name: 'MainTask',
  data() {
    return {
      taskName: '',
      taskNote: '',
      taskDate: '',
      taskTime: ''
    }
  },
  methods: {
    async onSubmit() {

      const { mutate: createTask, onDone } = useMutation(CREATE_TASK_MUTATION, {
        refetchQueries: [{ query: GET_ALL_TASKS_QUERY }],
      })

      createTask({
        id: Math.ceil(Math.random()*1000000), 
        name: this.taskName,
        notes: this.taskNote,
        dueDate: this.taskDate,
        time: this.taskTime,
        isComplete: false
      },
        onDone(result => {
          console.log(result.data)
        })
      )
    },

    async completed(id, isComplete) {

      const { mutate: taskCompleted, onDone } = useMutation(TASK_COMPLETED_MUTATION, {
        refetchQueries: [{ query: GET_ALL_TASKS_QUERY }],
      })
      taskCompleted({
        id: id,
        isComplete: isComplete ? false:true
      },
        onDone(result => {
          console.log(result.data)
        })
      )
    }
  },
  setup() {

    const { result, loading, error } = useQuery(GET_ALL_TASKS_QUERY);
    return {
      result,
      loading,
      error
    }
  }
}
</script>
<template>

  <!-- navbar -->
  <nav class="navbar navbar-dark navbar-expand-lg py-3 bg-dark">
    <div class="container">
      <a href="#" class="navbar-brand">Todo-application</a>
    </div>
  </nav>
  <!-- hero -->
  <section class="p-5 bg-primary text-center text-light hero">
    <div class="container pt-5">
      <h1>
        What do <span class="text-warning">you</span> want to do?
      </h1>
      <p class="lead my-4">Schedule a task</p>
      <button class="btn btn-success" type="button" data-bs-toggle="modal" data-bs-target="#addTaskModal"><i
          class="bi bi-plus"></i>Add a new task</button>
    </div>
  </section>
  <!-- Modal -->
  <div class="modal fade" id="addTaskModal" tabindex="-1" role="dialog" aria-labelledby="addTaskModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addTaskModalLabel">Add a new task</h5>
          <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <label for="taskName">Enter the name of the new task:</label>
              <input type="text" class="form-control" id="taskName" v-model="taskName" aria-describedby="taskNameHelp"
                placeholder="Enter task name" required>


              <label for="taskNotes">Enter the notes of the new task:</label>
              <input type="text" class="form-control" id="taskNotes" v-model="taskNote" aria-describedby="taskNotesHelp"
                placeholder="Enter task notes" required>


              <label for="taskDate">Pick a date</label>
              <input type="date" class="form-control" id="taskDate" v-model="taskDate" aria-describedby="taskDateHelp"
                placeholder="Choose a date" required>

              <label for="taskTime">Pick a time</label>
              <input type="time" class="form-control" id="taskTime" v-model="taskTime" aria-describedby="taskTimeHelp"
                placeholder="Choose a time" required>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button class="btn btn-primary" data-bs-dismiss="modal" type="submit" @click="onSubmit">Save changes</button>
        </div>
      </div>
    </div>
  </div>  
  <section class="container-md">
    <div class="accordion" id="accordionExample">
  <div class="accordion-item" v-for="task of result.getList" :key="task.id">
    <h2 class="accordion-header d-flex" :id="task.id">
      <button class="accordion-button" :class="task.isComplete ? 'complete':'incomplete'" type="button" data-bs-toggle="collapse" :data-bs-target="'#collapseOne' + task.id" aria-expanded="true" aria-controls="collapseOne">
        <span class="me-auto">Task: {{ task.name }}</span> <span class="ms-auto"> Due Date: {{task.dueDate}}</span> <span class="ms-3">{{task.time}}</span>
      </button>
      <button class="btn btn-warning" @click="completed(task.id, task.isComplete)" v-if="!task.isComplete">Incomplete<i class="bi bi-x-square-fill"></i></button>
      <button class="btn btn-success" @click="completed(task.id, task.isComplete)" v-else>Completed<i class="bi bi-check"></i></button>
      <button class="btn btn-danger">Remove Task</button>
    </h2>
    <div :id="'collapseOne' + task.id" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <strong>Details: {{ task.notes }}.</strong> 
      </div>
    </div>
  </div>
</div>
  </section>
  
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hero {
  height: 345px;
}
.complete {
  background: chartreuse;
}
.incomplete {
  background: blanchedalmond;
}

.accordion-button:not(.collapsed) {
  color: #212529;
}
</style>
