let marsApiButton = document.querySelectorAll("button[id*='marsExplorer']")

marsApiButton.forEach(button => button.addEventListener('click', function () {
                                        const buttonId = this.id
                                        const explorerName = buttonId.split('marsExplorer')[1]

                                        let explorerNameParameter = document.getElementById('marsExplorerName')
                                        explorerNameParameter.value = explorerName
                                        document.getElementById('formExplorerType').submit()
                                }))

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

let marsExplorerType = getUrlParameter("marsExplorerName")
highlightButtonByExplorerType(marsExplorerType)
document.getElementById('marsExplorerName').value = marsExplorerType


let sol = getUrlParameter("sol")
document.getElementById('sol').value = sol

function highlightButtonByExplorerType(explorerType) {
    if (explorerType == '') {
        explorerType = 'Opportunity'
    }
    document.getElementById('marsExplorer' + explorerType).classList.replace("btn-secondary", "btn-danger")
}

