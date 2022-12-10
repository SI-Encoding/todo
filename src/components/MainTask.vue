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
            <button class="btn btn-success"><i class="bi bi-plus"></i>Add a new task</button>
        </div>
    </section>
</template>

<script>
export default {
//   name: 'HelloWorld',
//   props: {
//     msg: String
//   }
name: 'MainTask'
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .hero {
        height: 345px;
    }
</style>
