function login(username,password) {
    let headers = new Headers();
    //headers.append('Content-Type', 'text/json');
    headers.append('Authorization', 'Basic ' + username + ":" + password);

    fetch('/user', {
        method: 'GET',
        headers: headers,
        credentials: 'include'
    })
        .then(response => response.json())
        .then(json => console.log(json))
    done(window.location.href="login.html");
}

function parseJSON(response) {return response.json()}

function sendemail() {

}