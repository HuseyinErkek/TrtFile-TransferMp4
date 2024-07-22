// Fonksiyon dosyayı yükleyecek ve gönderme işlemi yapacak
function sendFile() {
    // Form elemanlarından verileri al
    const folder = document.getElementById('folder').value;
    const fileInput = document.getElementById('file');
    const file = fileInput.files[0];
    const username = document.getElementById('usernameDisplay').textContent; // Kullanıcı adını buradan al

    // FormData nesnesini oluştur
    const formData = new FormData();
    formData.append('username', username); // Kullanıcı adını ekle
    formData.append('folder', folder); // Seçilen klasörü ekle
    formData.append('file', file); // Dosyayı ekle

    // Fetch API ile dosya yükleme işlemi
    fetch('/upload', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            // Başarıyla yüklenirse kullanıcıya mesaj göster
            if (data.success) {
                alert('Dosya başarıyla yüklendi.');
            } else {
                alert('Dosya yükleme başarısız.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Dosya yükleme sırasında bir hata oluştu.');
        });
}
