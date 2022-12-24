<script>
import NavBar from './NavBar.vue'
import HeroSection from './HeroSection.vue'
import ModalBody from './ModalBody.vue'
import ListTasks from './ListTasks.vue'

export default {
  name: 'MainTask',
  components: {
    NavBar, HeroSection, ModalBody, ListTasks
  }
}
</script>
<template>
  <!-- navbar -->
  <NavBar title="Todo-application"/>
  <!-- hero -->
  <HeroSection caption="Add a new task"/>
  <!-- Modal -->
  <ModalBody title="Add a new task"/>
  <!-- Tasks -->
  <ListTasks/>
</template>