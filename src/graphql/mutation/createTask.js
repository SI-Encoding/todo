import gql from 'graphql-tag'

export const CREATE_TASK_MUTATION = gql`
  mutation createTask ($id: ID!, $name: String!, $notes: String!, $dueDate: String!, $time: String!, $isComplete: Boolean!) {
        createTask (id: $id, name: $name, notes: $notes, dueDate: $dueDate, time: $time, isComplete: $isComplete) {
          id
          name
          notes
          dueDate
          time
          isComplete
        }
    }
`