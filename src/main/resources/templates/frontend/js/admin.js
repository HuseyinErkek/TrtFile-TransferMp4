document.addEventListener("DOMContentLoaded", function() {
    fetchAllLogs();
    fetchAllAccessRequests();
    fetchAllServerAccesses();
    fetchAllServers();
    fetchAllUsers();
});

function fetchAllLogs() {
    fetch('/admin/logs')
        .then(response => response.json())
        .then(data => {
            const logsContent = document.getElementById('logs-content');
            logsContent.innerHTML = JSON.stringify(data, null, 2); // Burada JSON verisini biçimlendirin
        });
}

function fetchAllAccessRequests() {
    fetch('/admin/access-requests')
        .then(response => response.json())
        .then(data => {
            const accessRequestsContent = document.getElementById('access-requests-content');
            accessRequestsContent.innerHTML = JSON.stringify(data, null, 2); // Burada JSON verisini biçimlendirin
        });
}

function fetchAllServerAccesses() {
    fetch('/admin/server-accesses')
        .then(response => response.json())
        .then(data => {
            const serverAccessesContent = document.getElementById('server-accesses-content');
            serverAccessesContent.innerHTML = JSON.stringify(data, null, 2); // Burada JSON verisini biçimlendirin
        });
}

function fetchAllServers() {
    fetch('/admin/servers')
        .then(response => response.json())
        .then(data => {
            const serversContent = document.getElementById('servers-content');
            serversContent.innerHTML = JSON.stringify(data, null, 2); // Burada JSON verisini biçimlendirin
        });
}

function fetchAllUsers() {
    fetch('/admin/users')
        .then(response => response.json())
        .then(data => {
            const usersContent = document.getElementById('users-content');
            usersContent.innerHTML = JSON.stringify(data, null, 2); // Burada JSON verisini biçimlendirin
        });
}
