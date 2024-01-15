<template>
  <div id="app-container">
    <NavBar />
    <div class="app-main-container">
      <router-view/>
    </div>
    <TheFooter />
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue';
import TheFooter from './components/TheFooter.vue';

export default {
  name: 'App',
  components: {
    NavBar,
    TheFooter,
  },
  data() {
    return {
      
    }
  },
}
</script>

<style>
  * {
    font-family: Helvetica;
    margin: 0;
    padding: 0px;
    box-sizing: border-box;
  }

  #app-container {
    display: flex;
    flex-direction: column;
    min-height: 100vh; /* 100% da altura da viewport */
  }

  .app-main-container {
    flex-grow: 1;
  }

  .main-container {
    margin: 15px;
  }


</style>
