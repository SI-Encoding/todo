<template>
  
  <!-- navbar-->
  <nav class="navbar navbar-dark navbar-expand-lg py-3 bg-dark">
        <div class="container">
            <a href="#" class="navbar-brand">Todo-application</a>
        </div>
    </nav>
    <!--hero-->
  <section class="p-5 bg-primary text-center text-light hero">
        <div class="container pt-5">
            <h1>
                What do <span class="text-warning">you</span> want to do?
            </h1>
            <p class="lead my-4">Schedule a task</p>
            <button class="btn btn-success" type="button" data-bs-toggle="modal" data-bs-target="#addTaskModal"><i class="bi bi-plus"></i>Add a new task</button>
        </div>
    </section>
    <!-- Modal -->
<div class="modal fade" id="addTaskModal" tabindex="-1" role="dialog" aria-labelledby="addTaskModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addTaskModalLabel">Add a new task</h5>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form  @submit.prevent="onSubmit">
            <div class="form-group">
                <label for="taskName">Enter the name of the new task:</label>
                <input type="text" class="form-control" id="taskName" v-model="taskName" aria-describedby="taskNameHelp" placeholder="Enter task name" required>
          
       
                <label for="taskNotes">Enter the notes of the new task:</label>
                <input type="text" class="form-control" id="taskNotes" v-model="taskNote" aria-describedby="taskNotesHelp" placeholder="Enter task notes" required>
       
        
                <label for="taskDate">Pick a date</label>
                <input type="date" class="form-control" id="taskDate" v-model="taskDate" aria-describedby="taskDateHelp" placeholder="Choose a date" required>
                <label for="taskTime">Pick a time</label>
                <input type="time" class="form-control" id="taskTime" v-model="taskTime" aria-describedby="taskTimeHelp" placeholder="Choose a time" required>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Save changes</button>
      </div>
    </div>
  </div>
</div>

</template>

<script>
export default {
//   name: 'HelloWorld',
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

}
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .hero {
        height: 345px;
    }
</style>
