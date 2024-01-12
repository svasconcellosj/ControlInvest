<template>
    <div id="ajustaDiv" class="alert alert-success" role="alert">
        <p>{{ msg }}</p>
    </div>
</template>

<script>
export default {
    name: 'MensagemAlerta',
    props: {
        msg: String
    }
}
</script>

<style scoped>
    #ajustaDiv {
        margin-top: 20px;
    }
</style>