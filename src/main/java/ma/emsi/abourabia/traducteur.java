package ma.emsi.abourabia;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class traducteur {
    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_KEY");


        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .build();


        PromptTemplate promptTemplate = PromptTemplate.from("Traduis le texte suivant en {{langue}} : {{texte}}");

        Prompt prompt = promptTemplate.apply(Map.of(
                "langue", "espagnol",
                "texte", "Bonjour, quelle est votre ville prefere  ?"
        ));

        // Génération de la réponse
        String traduction = model.generate(prompt.text());

        // Affichage
        System.out.println("Traduction : " + traduction);
    }
}
