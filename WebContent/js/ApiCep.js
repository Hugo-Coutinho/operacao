$(document).ready(function() {

	limpa_formulário_cep
            function limpaFormularioCep() {
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
            }
            
            $("#cep").blur(function() {

                var cep = $(this).val().replace(/\D/g, '');

                if (cep != "") {

                    var validacep = /^[0-9]{8}$/;

                    if(validacep.test(cep)) {

                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");

                        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                            } //end if.
                            else {
                            	limpaFormularioCep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                    	limpaFormularioCep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                	limpaFormularioCep();
                }
            });
        });
