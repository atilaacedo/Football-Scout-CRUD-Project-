function validar(){
    let nome = frmNovoJogador.nomeJogador.value
    let idade = frmNovoJogador.idadeJogador.value
    let nacionalidade = frmNovoJogador.nacionalidadeJogador.value
    let altura = frmNovoJogador.alturaJogador.value
    let posicao = frmNovoJogador.posicaoJogador.value
    let clube = frmNovoJogador.clubeJogador.value
    let descricao = frmNovoJogador.descricaoJogador.value
    
    if(nome === ""){
        alert('Preencha o campo Nome!')
        frmContato.nome.focus()
        return false
    }else if(idade === ""){
        alert('Preencha o campo Idade!')
        frmNovoJogador.idadeJogador.focus()
        return false
    }else if(nacionalidade === ""){
        alert('Preencha o campo nacionalidade!')
        frmNovoJogador.nacionalidadeJogador.focus()
        return false
    }else if(altura === ""){
        alert('Preencha o campo Altura!')
        frmNovoJogador.alturaJogador.focus()
        return false
    }else if(posicao === ""){
        alert('Preencha o campo Posição!')
        frmNovoJogador.posicaoJogador.focus()
        return false
    }else{
        document.forms["frmNovoJogador"].submit()
    }
}



