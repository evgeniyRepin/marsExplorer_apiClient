let marsApiButton = document.querySelectorAll("button[id*='marsExplorer']")

marsApiButton.forEach(button => addEventListener('click', function () {
        const buttonId = this.id
        const explorerId = buttonId.split('marsExplorer')[1]
        alert(this.id)
    }))