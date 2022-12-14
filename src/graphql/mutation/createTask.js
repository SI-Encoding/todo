import gql from 'graphql-tag'

export const CREATE_TASK_MUTATION = gql`
  mutation createTask ($name: String!, $notes: String!, $dueDate: String!, $time: String!, $isComplete: Boolean!) {
        createTask (name: $name, notes: $notes, dueDate: $dueDate, time: $time, isComplete: $isComplete) {
          name
          notes
          dueDate
          time
          isComplete
        }
    }
`