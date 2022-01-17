let marsApiButton = document.querySelectorAll("button[id*='marsExplorer']")

marsApiButton.forEach(button => button.addEventListener('click', function () {
                                        const buttonId = this.id
                                        const explorerId = buttonId.split('marsExplorer')[1]

                                        let apiData = document.getElementById('marsApiExplorerData')
                                        apiData.value = explorerId
                                        document.getElementById('formExplorerType').submit()
                                }))

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

let marsExplorerType = getUrlParameter("marsApiExplorerData")
highlightButtonByExplorerType(marsExplorerType)
document.getElementById('marsApiExplorerData').value = marsExplorerType


let sol = getUrlParameter("sol")
document.getElementById('sol').value = sol

function highlightButtonByExplorerType(explorerType) {
    if (explorerType == '') {
        explorerType = 'Opportunity'
    }
    document.getElementById('marsExplorer' + explorerType).classList.replace("btn-secondary", "btn-danger")
}

// if (marsExplorerType == 'Opportunity') {
//     document.getElementById('marsExplorerOpportunity').classList.replace("btn-secondary", "btn-danger")
// } else if (marsExplorerType == 'Curiosity'){
//     document.getElementById('marsExplorerCuriosity').classList.replace("btn-secondary", "btn-danger")
// } else if (marsExplorerType == 'Spirit'){
//     document.getElementById('marsExplorerSpirit').classList.replace("btn-secondary", "btn-danger")
// } else {
//     document.getElementById('marsExplorerOpportunity').classList.replace("btn-secondary", "btn-danger")
// }
