# O que o PR está fazendo?

Adicionando funcionalidades:

- Marcar um hábito como concluído.
- Adicionar novos hábitos clicando no botão add(FAB).

Mudanças na arquitetura:

- Os dados vão vir de um estado (UI State).
- UI State vai ser armazenado no escopo da ViewModel.
- O ViewModel esta conectado na View através da LiveData (vamos observar o LiveData).
- O MockHabits é substituído por uma interface de repositório simples.
