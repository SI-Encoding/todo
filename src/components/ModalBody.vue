<script>
import { useMutation } from '@vue/apollo-composable'
import { CREATE_TASK_MUTATION } from '../graphql/mutation/createTask'
import { GET_ALL_TASKS_QUERY } from '../graphql/queries/getList'

export default {
  props: {
  title: String
  },
  name: 'ModalBody',
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
    id: Math.ceil(Math.random() * 1000000),
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
}
}
</script>

<template>
    <div class="modal fade" id="addTaskModal" tabindex="-1" role="dialog" aria-labelledby="addTaskModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="addTaskModalLabel">{{title}}</h5>
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
</template>