// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function cargarUsuarios() {
    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: getHeaders()
    });
    const usuarios = await request.json();
    let listadoHtml = "";
    for (let user of usuarios) {
        let tele = user["telefono"] == null ? '-': user["telefono"];
        let usuarioHtml = '<tr>\n' +
            '<td>'+user["id"]+'</td>\n' +
            '<td>'+user["nombre"]+ ' ' + user["apellido"] + '</td>\n' +
            '<td>'+user["email"]+'</td>\n' +
            '<td>'+tele+'</td>\n' +
            '<td>\n' +
            '<a href="#" onclick="eliminarUsuario('+user["id"]+')" class="btn btn-danger btn-circle">\n' +
            '<i class="fas fa-trash"></i>\n' +
            '</a>\n' +
            '</td>\n' +
            '</tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

function getHeaders() {
return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
    };
}

async function eliminarUsuario(id) {

    if (!confirm("¿Desea eliminar este usuario?")) {
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload();
}