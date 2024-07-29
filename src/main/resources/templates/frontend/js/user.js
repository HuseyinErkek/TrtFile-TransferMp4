function getServerAddress(folder) {
    return new Promise((resolve, reject) => {
        fetch(`/getServerAddressByFolder?folder=${folder}`)
            .then(response => {
                if (response.ok) {
                    return response.text(); // veya response.json() kullanabilirsiniz
                } else {
                    throw new Error('Sunucu adresi alınamadı.');
                }
            })
            .then(address => resolve(address))
            .catch(error => reject(error));
    });
}

function sendFile() {
    // Form elemanlarından verileri al
    const folder = document.getElementById('folder').value;
    const fileInput = document.getElementById('file');
    const file = fileInput.files[0];
    const username = document.getElementById('usernameDisplay').textContent; // Kullanıcı adını buradan al

    // Sunucu adresini al
    getServerAddress(folder)
        .then(filePath => {
            if (!filePath) {
                alert('Sunucu adresi alınamadı.');
                return;
            }

            // FormData nesnesini oluştur
            const formData = new FormData();
            formData.append('username', username); // Kullanıcı adını ekle
            formData.append('folder', folder); // Gönderilecek klasörü ekle
            formData.append('file', file); // Dosyayı ekle
            formData.append('filePath', filePath); // Sunucu adresini ekle

            // Fetch API ile dosya yükleme işlemi
            return fetch('/upload', {
                method: 'POST',
                body: formData
            });
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
