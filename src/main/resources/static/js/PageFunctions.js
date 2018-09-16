function login(username,password) {

    fetch('/user', {
        method: 'GET',
        dataType: "json",
        contentType: "application/json",
        success: location.href = "AppPage.html"
    })
        .then(response => response.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(function(response) {
            let user = JSON.stringify(response);
            console.log(user.firstname)
            if(user.email == username) {
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

function createuser() {
    if ($('#id').val() > 0) {
        const url = "/edit";
    } else {
        url = "/newuser"
    }
    var data = {
        firstname:$('#firstname').val,
        surname:$('#surname').val,
        email:$('#email').val,
        password: $('#password').val
    }
    fetch(url, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    })
        .then(res => res.json())
        .then(response => console.log('Success:', JSON.stringify(response)))
        .then(function(response) {
            $('#create-user-modal').modal('hide');
        })
        .catch(error => console.error('Error:', error));
}

function logout() {
    localStorage.clear();
    location.href = "index.html"
}

function getData(data) {
    var result = {};
    $.map(data,function(n) { //tsükkel formi nimede täitmiseks väärtustega. Mäpi loomise funktsioon.
        result[n['name']] = n['value'];
    });
    return result;
}

function validateForm() {

}