<template>
    <nav class="navBar">
        <router-link to="/">Home</router-link>|
        <router-link to="/instituicoes">Instituicoes</router-link>
    </nav>
</template>

<script>

export default {
    nome: 'NavBar',

}
</script>

<style scoped>
    .navBar {
        background-color: rgb(55, 55, 196);
        color: #fff;
        padding: 10px 50px;
        display: flex;
        justify-content: flex-end;
        align-items: center;
    }
    .navBar a {
        color: #fff;
        text-decoration: none;
        margin: 10px;
        padding: 3px;
        transition: .5s;
    }
    .navBar a:hover {
        background-color: #fff;
        color:rgb(55, 55, 196);
        border-radius: 3px;
    }
</style>