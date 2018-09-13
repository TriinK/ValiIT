function login(username,password) {

    fetch('/user', {
        method: 'GET',
        credentials: 'include',
        //success: location.href = "AppPage.html"
    })
        .then(response => response.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(function(response) {
            let user = JSON.stringify(response);
            console.log(user.email)
            if(user.email == $('#username').val) {
                location.href = "AppPage.html"
            } else {
                console.log("Does it go here!")
            }
        });
}

function parseJSON(response) {return response.json()}

function sendemail() {
    let email = $('#forgot-email').val();
    $('#forgot-password').modal('hide');
    alert("Email has been sent!");
}

function createuser(customerId) {
    if ($('#id').val() > 0) {
        const url = "/edit";
    } else {
        url = "/newuser";
    }
    fetch(url, {
        method: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify((getData($('form[id=create-user-modal]').serializeArray()))),
        complete: function (response) {
            giveMeAllUsers();
        }
    })
        .then(res=>res.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(function(response) {
            let user = JSON.stringify(response);
            $('#id').val(user.id);
            $('#firstname').val(user.firstname);
            $('#surname').val(user.surname);
            $('#email').val(user.email);
            $('#user').val(user.password);
            $('#create-user-modal').modal('hide');
        })
        .catch(error => console.error('Error:', error));
}

function logout() {
    localStorage.clear();
    location.href = "index.html"
}

function getData(data) {
    let result = {};
    $.map(data,function(n) { //tsükkel formi nimede täitmiseks väärtustega. Mäpi loomise funktsioon.
        result[n['name']] = n['value'];
    });
    return result;
}