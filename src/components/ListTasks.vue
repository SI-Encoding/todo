<script>
import { useMutation } from '@vue/apollo-composable'
import { TASK_COMPLETED_MUTATION } from '../graphql/mutation/taskCompleted'
import { TASK_REMOVE_MUTATION } from '../graphql/mutation/removeTask'
import { GET_ALL_TASKS_QUERY } from '../graphql/queries/getList'
import { useQuery } from '@vue/apollo-composable'

export default {
    name: 'ListTasks',
    methods: {
        async completed(id, isComplete) {

            const { mutate: taskCompleted, onDone } = useMutation(TASK_COMPLETED_MUTATION, {
            refetchQueries: [{ query: GET_ALL_TASKS_QUERY }],
            })
            taskCompleted({
            id: id,
            isComplete: isComplete ? false : true
            },
            onDone(result => {
                console.log(result.data)
            })
            )
        },

        async removeTask(id) {

            const { mutate: removeTask, onDone } = useMutation(TASK_REMOVE_MUTATION, {
            refetchQueries: [{ query: GET_ALL_TASKS_QUERY }],
            })
            removeTask({
            id
            }),
            onDone(result => {
                console.log(result.data)
            })
        }
    },
    setup() {

        try {
        const { result, loading, error } = useQuery(GET_ALL_TASKS_QUERY);
        return {
            result,
            loading,
            error
        }
        } catch(err) {
            console.log(err)
        }
    }
}
</script>

<template>
    <section class="container-md">
    <div class="accordion" id="accordionExample">
      <div class="accordion-item" v-for="task of result.getList" :key="task.id">
        <h2 class="accordion-header d-flex" :id="task.id">
          <button class="accordion-button" :class="task.isComplete ? 'complete' : 'incomplete'" type="button"
            data-bs-toggle="collapse" :data-bs-target="'#collapseOne' + task.id" aria-expanded="true"
            aria-controls="collapseOne">
            <span class="me-auto">Task: {{ task.name }}</span> <span class="ms-auto"> Due Date: {{ task.dueDate }}</span>
            <span class="ms-3">{{ task.time }}</span>
          </button>
          <button class="btn btn-warning" @click="completed(task.id, task.isComplete)"
            v-if="!task.isComplete">Incomplete<i class="bi bi-x-square-fill"></i></button>
          <button class="btn btn-success" @click="completed(task.id, task.isComplete)" v-else>Completed<i
              class="bi bi-check"></i></button>
          <button class="btn btn-danger" @click="removeTask(task.id)">Remove Task</button>
        </h2>
        <div :id="'collapseOne' + task.id" class="accordion-collapse collapse" aria-labelledby="headingOne"
          data-bs-parent="#accordionExample">
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