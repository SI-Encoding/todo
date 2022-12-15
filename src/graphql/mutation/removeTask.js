import gql from 'graphql-tag'

export const TASK_REMOVE_MUTATION = gql`
    mutation removeTask($id: ID!) {
        removeTask(id: $id) {
            id
        }
    }
`
