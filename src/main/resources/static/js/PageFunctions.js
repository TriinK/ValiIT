function login(username,password) {
    let headers = new Headers();
    //headers.append('Content-Type', 'text/json');
    headers.append('Authorization', 'Basic ' + username + ":" + password);

    fetch('/user', {
        method: 'GET',
        headers: headers,
        credentials: 'include',
        success: location.href = "AppPage.html"
    })
        .then(response => response.json())
        .then(json => console.log(json));
}

function parseJSON(response) {return response.json()}

function sendemail() {
    let email = $('#forgot-email').val();
    window.open('mailto:triinkkask@gmail.com');
}

function createuser() {
    fetch('/newuser', {
        method: 'PUT',
        dataType: "json",
        contentType: "application/json",
        credentials: 'include',
        success: location.href = "App.html"
    })
        .then(function(response) {
            let user = response.responseJSON;
            $('#id').val(user.id);
            $('#firstname').val(user.firstname);
            $('#surname').val(user.surname);
            $('#email').val(user.email);
            $('#user').val(user.password);
            $('#create-user-modal').modal('hide');
        })
}

function logout() {
    localStorage.clear();
    location.href = "AppPage.html"
}