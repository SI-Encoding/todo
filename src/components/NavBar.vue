<script>
export default {
props: {
title: String
},
name: 'NavBar'
}
</script>

<template>
    <nav class="navbar navbar-dark navbar-expand-lg py-3 bg-dark">
    <div class="container">
      <a href="#" class="navbar-brand">{{title}}</a>
    </div>
  </nav>
</template>