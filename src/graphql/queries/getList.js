import gql from 'graphql-tag'

export const GET_ALL_TASKS_QUERY = gql`
  query getList {
    getList {
        name
        notes
        dueDate
        isComplete
    }
  }
`