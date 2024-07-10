// Kullanıcı bilgileri (örneğin, bu verileri backend'den alabilirsiniz)
const userData = {
    username: "huso",
    name: "Hüseyin Erkek"
};

// Sayfa yüklendiğinde yapılacak işlemler
document.addEventListener("DOMContentLoaded", function() {
    // Kullanıcı bilgilerini göster
    displayUserInfo(userData.username, userData.name);
});

// Kullanıcı bilgilerini göstermek için fonksiyon
function displayUserInfo(username, name) {
    document.getElementById("usernameDisplay").textContent = username;
    document.getElementById("nameDisplay").textContent = name;
}

// Dosya gönderme işlemi
function sendFile() {
    var selectedFolder = document.getElementById('folder').value;
    var selectedFile = document.getElementById('file').files[0];

    // Dosya gönderme işlemleri burada yapılabilir (örneğin, FTP ile gönderim)
    // Bu örnekte sadece alert ile gönderildiğini bildiriyoruz
    alert('Dosya gönderildi!');
}
