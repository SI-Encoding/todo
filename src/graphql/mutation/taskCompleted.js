import gql from 'graphql-tag'

export const TASK_COMPLETED_MUTATION = gql`
  mutation taskCompleted ($id: ID!, $isComplete: Boolean!) {
        taskCompleted (id: $id, isComplete: $isComplete) {
          id
          isComplete
        }
    }
`