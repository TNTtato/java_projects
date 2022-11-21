// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});

async function registarUsuario() {
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repeatPass = document.getElementById('txtRepeatPassword').value;

    if (repeatPass != datos.password) {
        alert("La contraseña no coincide, vuelve a introducirla");
        return;
    }
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("La cuenta fue creada con exito");
    window.location.href = "login.html"
}
