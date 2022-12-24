<script>
export default {
props: {
caption: String
},
name: 'HeroSection'
}
</script>

<template>
    <section class="p-5 bg-primary text-center text-light hero">
    <div class="container pt-5">
      <h1>
        What do <span class="text-warning">you</span> want to do?
      </h1>
      <p class="lead my-4">Schedule a task</p>
      <button class="btn btn-success" type="button" data-bs-toggle="modal" data-bs-target="#addTaskModal"><i
          class="bi bi-plus"></i>{{caption}}</button>
    </div>
  </section>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hero {
  height: 345px;
}
</style>